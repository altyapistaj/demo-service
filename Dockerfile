FROM public.ecr.aws/amazoncorretto/amazoncorretto:21
        COPY docker/layers/application/ ./
        COPY docker/layers/snapshot-dependencies/ ./
        COPY docker/layers/spring-boot-loader/ ./
        COPY docker/layers/dependencies/ ./
        ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]