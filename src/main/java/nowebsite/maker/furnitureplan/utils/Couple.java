package nowebsite.maker.furnitureplan.utils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Function;

@SuppressWarnings("unused")
public record Couple<F, S, T>(F first, S second, T third) {
    @Contract(" -> new")
    public @NotNull Couple<T, S, F> reverse() {
        return of(third, second, first);
    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Couple<?, ?, ?> other)) {
            return false;
        }
        return Objects.equals(first, other.first) && Objects.equals(second, other.second);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(first, second);
    }

    @Contract("_ -> new")
    public <F2> @NotNull Couple<F2, S, T> mapFirst(final @NotNull Function<? super F, ? extends F2> function) {
        return of(function.apply(first), second, third);
    }

    @Contract("_ -> new")
    public <S2> @NotNull Couple<F, S2, T> mapSecond(final @NotNull Function<? super S, ? extends S2> function) {
        return of(first, function.apply(second), third);
    }

    @Contract("_ -> new")
    public <T2> @NotNull Couple<F, S, T2> mapThird(final @NotNull Function<? super T, ? extends T2> function) {
        return of(first, second, function.apply(third));
    }

    @Contract("_, _, _ -> new")
    public static <F, S, T> @NotNull Couple<F, S, T> of(final F first, final S second, final T third) {
        return new Couple<>(first, second, third);
    }
}
