package test;

public class Range<T extends Comparable<T>> {
    private T start;
    private T end;

    private Range(T start, T end) {
        this.start = start;
        this.end = end;
    }

    public static <T extends Comparable<T>> Range<T> of(T start, T end) {
        if (start.compareTo(end) > 0) {
            //throws IllegalArgumentException if the start value is greater than the end value 
            throw new IllegalArgumentException("Start should be less than or equal to end.");
        }
        return new Range<>(start, end);
    }

    public boolean contains(T value) {
        return value.compareTo(start) >= 0 && value.compareTo(end) <= 0;
    }

    public boolean containsRange(Range<T> otherRange) {
        return this.start.compareTo(otherRange.start) <= 0 && this.end.compareTo(otherRange.end) >= 0;
    }

    public Range<T> merge(Range<T> otherRange) throws CustomException {
        if (this.end.compareTo(otherRange.start) < 0 || this.start.compareTo(otherRange.end) > 0) {
            throw new CustomException("Ranges cannot be merged.");
        }
        T newStart = this.start.compareTo(otherRange.start) < 0 ? this.start : otherRange.start;
        T newEnd = this.end.compareTo(otherRange.end) > 0 ? this.end : otherRange.end;
        return new Range<>(newStart, newEnd);
    }

    public Range<T> intersection(Range<T> otherRange) throws CustomException {
        if (this.end.compareTo(otherRange.start) < 0 || this.start.compareTo(otherRange.end) > 0) {
            throw new CustomException("No intersection between ranges.");
        }
        T newStart = this.start.compareTo(otherRange.start) > 0 ? this.start : otherRange.start;
        T newEnd = this.end.compareTo(otherRange.end) < 0 ? this.end : otherRange.end;
        return new Range<>(newStart, newEnd);
    }

    public T fit(T element) {
        if (element.compareTo(start) < 0) {
            return start;
        } else if (element.compareTo(end) > 0) {
            return end;
        }
        return element;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Range<?> range = (Range<?>) obj;
        return start.equals(range.start) && end.equals(range.end);
    }
}


