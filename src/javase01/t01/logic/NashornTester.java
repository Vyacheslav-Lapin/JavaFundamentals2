package javase01.t01.logic;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class GenericRestriction<T> {
    //    private static T x; // error
    private T y;

    public static <Type extends Number> Type method() {


//        T var; // error
        return (Type) new Integer(1);
//        return (Type) new StringBuffer("12345").toString();
    }

    public static void main(String[] args) throws ScriptException {
//        final Number method = GenericRestriction.method();
//        System.out.println(method);

        int i = (Integer) new ScriptEngineManager()
                .getEngineByName("nashorn")
                .eval(
//                        "'HelloWorld'.length"
                        "var OneAbsMethodClass = Java.type('javase01.t01.logic.OneAbsMethodClass');" +
                                "new OneAbsMethodClass(function() { return 1; }).m2()"
                );
        System.out.println(i);
    }
}
