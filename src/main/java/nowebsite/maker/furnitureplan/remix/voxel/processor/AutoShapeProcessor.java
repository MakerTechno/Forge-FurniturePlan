package nowebsite.maker.furnitureplan.remix.voxel.processor;

import com.google.auto.service.AutoService;
import nowebsite.maker.furnitureplan.remix.voxel.VoxelShapeUtil.VoxelType;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SupportedAnnotationTypes("nowebsite.maker.furnitureplan.remix.voxel.processor.AutoShape")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
@AutoService(Processor.class)
public class AutoShapeProcessor extends AbstractProcessor {
    
    private Elements elementUtils;
    private Messager messager;
    private Filer filer;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.elementUtils = processingEnv.getElementUtils();
        this.messager = processingEnv.getMessager();
        this.filer = processingEnv.getFiler();
    }
    
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> annotatedFields = roundEnv.getElementsAnnotatedWith(AutoShape.class);
        
        if (annotatedFields.isEmpty()) {
            return true;
        }
        
        var groupedByClass = annotatedFields.stream()
            .collect(Collectors.groupingBy(Element::getEnclosingElement));
        
        for (var entry : groupedByClass.entrySet()) {
            TypeElement classElement = (TypeElement) entry.getKey();
            List<VariableElement> fields = entry.getValue().stream()
                .map(e -> (VariableElement) e)
                .collect(Collectors.toList());
            
            generateShapeHolder(classElement, fields);
        }
        
        return true;
    }
    
    private void generateShapeHolder(TypeElement classElement, List<VariableElement> fields) {
        String packageName = elementUtils.getPackageOf(classElement).getQualifiedName().toString();
        String genClassName = "ShapesGen";
        
        try {
            JavaFileObject sourceFile = filer.createSourceFile(packageName + "." + genClassName);
            try (PrintWriter out = new PrintWriter(sourceFile.openWriter())) {
                
                out.println("package " + packageName + ";");
                out.println();
                out.println("import net.minecraft.core.Direction;");
                out.println("import net.minecraft.world.phys.AABB;");
                out.println("import net.minecraft.world.phys.shapes.VoxelShape;");
                out.println("import net.minecraft.world.phys.shapes.BooleanOp;");
                out.println("import " + AutoShape.class.getPackageName() + ".*;");
                out.println();
                out.println("/**");
                out.println(" * 自动生成的形状持有器");
                out.println(" * 请勿手动修改，修改源文件后重新编译即可");
                out.println(" */");
                out.println("public final class " + genClassName + " {");
                out.println("    private " + genClassName + "() {}");
                out.println();
                
                for (VariableElement field : fields) {
                    generateFieldConstant(out, field, classElement);
                }
                
                out.println("}");
            }
        } catch (Exception e) {
            messager.printMessage(Diagnostic.Kind.ERROR, "Failed to generate shape holder: " + e.getMessage());
        }
    }
    
    private void generateFieldConstant(PrintWriter out, VariableElement field, TypeElement classElement) {
        AutoShape annotation = field.getAnnotation(AutoShape.class);
        VoxelType type = annotation.type();
        
        String constantName = annotation.name();
        if (constantName.isEmpty()) {
            String fieldName = field.getSimpleName().toString();
            constantName = toCamelCase(fieldName);
        }
        
        String fieldRef = classElement.getSimpleName() + "." + field.getSimpleName();
        
        out.println("    /** 自动生成: " + constantName + " */");
        out.println("    public static final IVoxelHolder " + constantName + " = build_" + constantName + "();");
        out.println();
        out.println("    private static IVoxelHolder build_" + constantName + "() {");
        
        switch (type) {
            case ONLY -> {
                out.println("        VoxelShape shape = ShapeBuilderHelper.buildShapeFromEntries(" + fieldRef + ");");
                out.println("        return new OnlyCollision(shape);");
            }
            case X_ROTATE -> {
                out.println("        List<VoxelShape> shapes = ShapeBuilderHelper.buildRotatedShapes(" + fieldRef + ", RotateCollision.Axis.X);");
                out.println("        return new RotateCollision(RotateCollision.Axis.X, shapes.get(0), shapes.get(1), shapes.get(2), shapes.get(3));");
            }
            case Y_ROTATE -> {
                out.println("        List<VoxelShape> shapes = ShapeBuilderHelper.buildRotatedShapes(" + fieldRef + ", RotateCollision.Axis.Y);");
                out.println("        return new RotateCollision(RotateCollision.Axis.Y, shapes.get(0), shapes.get(1), shapes.get(2), shapes.get(3));");
            }
            case Z_ROTATE -> {
                out.println("        List<VoxelShape> shapes = ShapeBuilderHelper.buildRotatedShapes(" + fieldRef + ", RotateCollision.Axis.Z);");
                out.println("        return new RotateCollision(RotateCollision.Axis.Z, shapes.get(0), shapes.get(1), shapes.get(2), shapes.get(3));");
            }
        }
        
        out.println("    }");
        out.println();
    }
    
    private String toCamelCase(String name) {
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;
        for (char c : name.toLowerCase().toCharArray()) {
            if (c == '_' || c == ' ') {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                result.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}