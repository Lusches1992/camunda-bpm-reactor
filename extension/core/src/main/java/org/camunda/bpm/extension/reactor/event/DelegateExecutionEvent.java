package org.camunda.bpm.extension.reactor.event;

import org.camunda.bpm.engine.ProcessEngineException;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import java.util.function.Consumer;

public class DelegateExecutionEvent extends DelegateEvent<DelegateExecution> {

  public static Consumer<DelegateExecutionEvent> consumer(final ExecutionListener listener) {
    return event -> {
      try {
        listener.notify(event.getData());
      } catch (Exception e) {
        throw new ProcessEngineException(e);
      }
    };
  }

  private static final long serialVersionUID = 1L;

  public DelegateExecutionEvent(final DelegateExecution data) {
    super(data);
  }
}
