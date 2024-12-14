package com.example.demo;

import io.awspring.cloud.autoconfigure.config.parameterstore.ParameterStoreConfigDataLoader;
import io.awspring.cloud.autoconfigure.config.parameterstore.ParameterStorePropertySources;
import io.awspring.cloud.parameterstore.ParameterStorePropertySource;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeReference;

public class NativeHintsParameterStore implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {

        hints.reflection().registerType(TypeReference.of(ParameterStorePropertySources.class),
                hint -> hint.withMembers(MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
                        MemberCategory.INTROSPECT_DECLARED_METHODS, MemberCategory.DECLARED_FIELDS));
        hints.reflection().registerType(TypeReference.of(ParameterStorePropertySource.class),
                hint -> hint.withMembers(MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
                        MemberCategory.INTROSPECT_DECLARED_METHODS, MemberCategory.DECLARED_FIELDS));
        hints.reflection().registerType(TypeReference.of(ParameterStoreConfigDataLoader.class),
                hint -> hint.withMembers(MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
                        MemberCategory.INTROSPECT_DECLARED_METHODS, MemberCategory.DECLARED_FIELDS));

        hints.resources().registerPattern("io/awspring/cloud/core/SpringCloudClientConfiguration.properties");
    }
}
