package util;

public class SequenceId {
    private static int idSeq;

    public static int nextVal(){
        return ++idSeq;
    }
}
