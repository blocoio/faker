package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

import java.util.Collection;
/**
 * Class to pick random items from a known collection, enum, array or VargArgs
 */
public class PickRandom extends FakerComponent {

    public PickRandom(FakerData data) {
        super(data);
    }

    < T extends Enum<T>>T fromEnum(Class<T> clazz){

        Object[] possibleValues = null;

        if(clazz != null) {

            possibleValues = clazz.getEnumConstants();

        } else {

            throw new IllegalArgumentException("The class passed in the argument is null");
        }


        return fromArray((T[]) possibleValues);
    }

    <T > T fromArray(T[] array) {

        Integer  randex = randomHelper.number(array.length - 1);

        return array[randex];
    }


    @SafeVarargs
    final <T > T fromVarArgs(T... array){

        return fromArray(array);
    }

    @SuppressWarnings("unchecked")
    <T > T fromCollection(Collection<T> coll){

        return fromArray((T[]) coll.toArray());
    }
}
