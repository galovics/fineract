package org.apache.fineract.test.support;

import static java.lang.ThreadLocal.withInitial;

import java.util.HashMap;
import java.util.Map;

public enum TestContext {

    INSTANCE;

    private final ThreadLocal<Map<String, Object>> testContexts = withInitial(HashMap::new);

    public <T> T get(String name) {
        Object storedValue = testContexts.get().get(name);
        return (T) storedValue;
    }

    public Map<String, Object> get() {
        return testContexts.get();
    }

    public <T> void set(String name, T object) {
        testContexts.get().put(name, object);
    }

    public void reset() {
        testContexts.get().clear();
    }
}
