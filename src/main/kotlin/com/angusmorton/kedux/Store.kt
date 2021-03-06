package com.angusmorton.kedux

interface Store<S, A> {

    /**
     * @return the current state of the [Store].
     */
    var state : S

    /**
     * Dispatches an action. It is the only way to trigger a state change.
     *
     * The `reducer` function, used to create the store, will be called with the
     * current state and the given `action`. Its return value will
     * be considered the **next** state of the tree, and the change listeners
     * will be notified.
     *
     *  @param action An object representing “what changed”. It is
     * a good idea to keep actions serializable so you can record and replay user
     * sessions, or use time travelling.
     *
     * @returns the same action object you dispatched.
     *
     */
    fun dispatch(action: A): A

    /**
     * Adds a change listener. It will be called any time an action is dispatched,
     * and some part of the state tree may potentially have changed.
     *
     * @param subscriber function to be invoked on every dispatch.
     * @returns A function to remove this change listener.
     */
    fun subscribe(subscriber: (S) -> Unit): Subscription

    companion object {
        fun <S, A> create(initialState: S, reducer: (S, A) -> S) : Store<S, A> {
            return StoreImpl(initialState, reducer)
        }
    }
}