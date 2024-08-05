package app.operators;


import com.megadeploy.annotations.core.Operator;

@Operator
public class MyOperator {

    private final String operatorName;

    public MyOperator() {
        this.operatorName = "My Operator";
    }

    public String operatorName() {
        return operatorName;
    }
}
