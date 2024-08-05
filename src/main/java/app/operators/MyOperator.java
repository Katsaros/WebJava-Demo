package app.operators;

import com.megadeploy.annotations.core.AutoInitialize;

@AutoInitialize
public class MyOperator {

    private final String operatorName;

    public MyOperator() {
        this.operatorName = "My Operator";
    }

    public String operatorName() {
        return operatorName;
    }
}
