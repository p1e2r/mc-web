package com.lmax.disruptor;
/** mc-web stub of the optional Disruptor dependency of log4j-core. */
public interface EventTranslatorTwoArg<T, A, B> { void translateTo(T event, long sequence, A arg0, B arg1); }
