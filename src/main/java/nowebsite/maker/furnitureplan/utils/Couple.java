package nowebsite.maker.furnitureplan.utils;

import java.util.Objects;
import java.util.function.Function;

public record Couple<F, S, T>(F first, S second, T third) {
    public Couple<T, S, F> reverse() {
        return of(third, second, first);
    }

    @Override
    public String toString() {
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

    public <F2> Couple<F2, S, T> mapFirst(final Function<? super F, ? extends F2> function) {
        return of(function.apply(first), second, third);
    }

    public <S2> Couple<F, S2, T> mapSecond(final Function<? super S, ? extends S2> function) {
        return of(first, function.apply(second), third);
    }

    public <T2> Couple<F, S, T2> mapThird(final Function<? super T, ? extends T2> function) {
        return of(first, second, function.apply(third));
    }

    public static <F, S, T> Couple<F, S, T> of(final F first, final S second, final T third) {
        return new Couple<>(first, second, third);
    }
}
