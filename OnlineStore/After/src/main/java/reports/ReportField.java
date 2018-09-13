package reports;

import lombok.Getter;

@Getter
public class ReportField<T> {
    private String label;
    private T value;

    public ReportField(T value){
        this.value = value;
    }
}
