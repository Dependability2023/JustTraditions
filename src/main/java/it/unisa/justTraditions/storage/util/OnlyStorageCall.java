package it.unisa.justTraditions.storage.util;

import java.util.List;

public abstract class OnlyStorageCall {
  private static final StackWalker stackWalker = StackWalker.getInstance();

  public static void validateCall() {
    List<StackWalker.StackFrame> stackFrames = stackWalker.walk(s ->
        s.skip(1)
            .limit(2)
            .toList()
    );

    String callerClassName = stackFrames.get(1).getClassName();
    if (!callerClassName.startsWith("it.unisa.justTraditions.storage")) {
      String methodName = stackFrames.get(0).getMethodName();
      throw new IllegalCallerException(methodName + " called from " + callerClassName);
    }
  }
}
