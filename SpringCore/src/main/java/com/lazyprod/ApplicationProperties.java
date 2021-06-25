package com.lazyprod;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("com.lazyprod")
@Getter
@Setter
@ToString
@Validated
@Component
public final class ApplicationProperties {

    private Quiz quiz = new Quiz();

    @Getter
    @Setter
    @ToString
    public final class Quiz {

        private Tasks tasks = new Tasks();

        @Getter
        @Setter
        @ToString
        public final class Tasks {

            private Source source = new Source();

            @Getter
            @Setter
            @ToString
            public final class Source {

                private File file = new File();

                @Getter
                @Setter
                @ToString
                public final class File {

                    private String pattern;
                    private String extension;

                }
            }

        }

    }

}
