package it.unisa.justTraditions.storage.util;

public abstract class OnlyStorageCall {
  public static void validateCall() {
    Class<?> callerClass = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
        .walk(s -> s.map(StackWalker.StackFrame::getDeclaringClass)
            .skip(2)
            .findFirst()
        ).orElseThrow();
    
    if (!callerClass.getName().startsWith("it.unisa.justTraditions.storage")) {
      throw new IllegalCallerException();
    }
  }
}
