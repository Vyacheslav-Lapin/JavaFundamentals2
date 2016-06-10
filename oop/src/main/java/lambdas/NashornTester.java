package lambdas;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornTester {

    public static void main(String[] args) throws ScriptException {
        // TODO: 6/3/2016 вынести скрипт в отдельный файл
        int i = (Integer) new ScriptEngineManager()
                .getEngineByName("nashorn")
                .eval("var OneAbsMethodClass = Java.type('lambdas.OneAbsMethodClass');"
                + "new OneAbsMethodClass(function() 1).getAnInt()");

        System.out.println(i); // "1"
    }
}
