package ravens.analyser.processor.wrapper;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Set;

import ravens.analyser.cfg.ControlFlowGraph;
import ravens.analyser.dataflow.DefUse;
import ravens.analyser.ConditionalListeners;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtTypeReference;

/**
 * This class contains direct access to methods identified as listeners
 */
public class ListenersWrapper {

	List<CtMethod<?>>					listeners;

	List<CtMethod<?>>					condListeners;

	// Control Flow Graphs
	Map<CtMethod<?>, ControlFlowGraph>	cfgs;

	// Def-Use chains
	Map<CtMethod<?>, DefUse>			defuses;

	// Used events
	Set<CtTypeReference<?>>				events;

	/**
	 * Compute control flow graphs, definition-use chains and store them with
	 * the listeners
	 */
	public void create(List<CtMethod<?>> listens, Set<CtTypeReference<?>> evts) {

		this.listeners = listens;
		this.cfgs = new HashMap<>();
		this.defuses = new HashMap<>();
		this.events = evts;
		ConditionalListeners conditionals = new ConditionalListeners(listens);
		this.condListeners = conditionals.getCondListeners();

		for (CtMethod<?> listener : listens) {
			ControlFlowGraph cfg = new ControlFlowGraph(listener);
			DefUse defuse = new DefUse(cfg);

			cfgs.put(listener, cfg);
			defuses.put(listener, defuse);
		}
	}

	/**
	 * Get methods found in the source code which extend EventListener, Swing
	 * listeners or AWT listeners.
	 */
	public List<CtMethod<?>> getListeners() {
		return listeners;
	}

	/**
	 * Get listener methods that has conditional blocks.
	 */
	public List<CtMethod<?>> getConditionalListeners() {
		return condListeners;
	}

	/**
	 * Helper to get the class where the method is declared
	 */
	public CtClass<?> getDeclaringClass(CtMethod<?> listener) {
		return (CtClass<?>) listener.getDeclaringType(); // TODO: should check
															// the cast
	}

	/**
	 * Get the control flow analysis for this listener. Return null if not found
	 */
	public ControlFlowGraph getControlFlowGraph(CtMethod<?> listener) {
		return cfgs.get(listener);
	}

	/**
	 * Get the definition-use analysis for this listener. Return null if not
	 * found
	 */
	public DefUse getDefUse(CtMethod<?> listener) {
		return defuses.get(listener);
	}

	/**
	 * Get events targeted by listeners
	 */
	public Set<CtTypeReference<?>> getAllEvents() {
		return events;
	}
}
