package com.aol.cyclops.internal.stream.spliterators;

import java.util.Spliterator;
import java.util.Spliterators.AbstractSpliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class LimitLastOneSpliterator<T> extends AbstractSpliterator<T>{

   
    private static final Object UNSET = new Object();
    private volatile Object buffer;
    private final Spliterator<T> source;

    public LimitLastOneSpliterator(final Spliterator<T> source) {
        super(source.estimateSize(),source.characteristics());
        buffer = UNSET;
        this.source = source;
        
    }

    
    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        System.out.println("Limit last one " + source);
        source.forEachRemaining(e -> { // onNext add to buffer
            System.out.println("Buffer " + e );
            buffer = e;
        });
        if (buffer == UNSET)
            return false;
        action.accept((T) buffer);
        return false;
    }
   
}
