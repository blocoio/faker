package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

import java.util.Collection;
import java.util.Optional;

/**
 * Class to pick random items from a known collection, enum, array or VargArgs
 */
public class PickRandom extends FakerComponent {

    public PickRandom(FakerData data) {
        super(data);
    }

    @SuppressWarnings("all")
    public < T extends Enum<T>>T fromEnum(Class<T> clazz){

        Optional<Object[]> possibleValues = Optional.empty();

        if(clazz != null) {

            possibleValues = Optional.of(clazz.getEnumConstants());

        } else {

            throw new IllegalArgumentException("The class : "+clazz+" is empty");
        }


        return fromArray((T[]) possibleValues.get());
    }

    @SuppressWarnings("all")
    public <T > T fromArray(T[] array) {

        Optional<T[]> randomArray = Optional.of(array);

        Optional<Integer> randex =
                Optional.of(randomHelper.number(randomArray.get().length - 1));

        return randomArray.get()[randex.get()];
    }


    @SafeVarargs
    @SuppressWarnings("all")
    public final <T > T fromVarArgs(T... array){

        return fromArray(array);
    }

    @SuppressWarnings({"unused","unchecked","all"})
    public <T > T fromCollection(Collection<T> coll){

        return fromArray((T[]) coll.toArray());
    }
}
