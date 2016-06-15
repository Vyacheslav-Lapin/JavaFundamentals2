package generics;

import lombok.*;
import lombok.extern.java.Log;

/**
 * Что бы заработало, нужно:
 * 1. Настроить Annotation Processing. Это делается в настройках Intellij IDEA'и в настройках в разделе
 * 'Build, Execution, Deployment' -> 'Compiler' -> 'Annotation Processors' и отметить там галочку
 * 'Enable Annotation Procession'.
 * 2. Поставить plugin 'Lombok' для IDEA'и
 *
 * В итоге (см. LombokDemoTest):
 * - Несмотря на то, что класс не содержит конструктора, его экземпляр можно создать, вызвав конструктор с тремя
 * параметрами.
 * - Несмотря на то, что класс не содержит get'теров с set'терами, их можно вызывать для всех его private'ных полей.
 * - Несмотря на то, что класс не содержит реализации метода toString, он вернёт адаптированное значение.
 * - Несмотря на то, что класс не содержит Logger'а, к его переменной 'log' можно обращаться и она будет выводить
 * корректные данные в log.
 * - Несмотря на то, что класс не содержит реализации методов equals и hashCode, они присутствуют в нём.
 *
 * Что бы посмотреть на код, который Lombok генерирует для данного класса в процессе компиляции, выберите в контекстном
 * меню 'Refactor' -> 'Delombok' -> 'All lombok annotations'
 */
@AllArgsConstructor
@Data //@ToString @EqualsAndHashCode @Getter @Setter @RequiredArgsConstructor
@Log
public class LombokDemo {
    private int anInt;
    private double aDouble;
    private String string;

    public boolean isLogger() {
        log.info("info");
        return true;
    }
}