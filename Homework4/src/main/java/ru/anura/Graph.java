package main.java.ru.anura;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Граф для любых типов объектов.
 * @param <Type> тип
 */
public class Graph<Type extends GraphKey> {
    /** Хранилище данных. */
    private Map<Integer, Type> vertex = new HashMap<>();
    private Map<Integer, ArrayList<Type>> edge = new HashMap<>();

    /**
     * Добавляем вершину.
     *
     * @param value объект
     */
    public void putVertex(Type value) {
        vertex.put(value.getKey(), value);
    }

    /**
     * Добавляем ребро.
     *
     * @param value объект
     */
    public void putEdge(Type value,Type vertex1, Type vertex2) {
        ArrayList<Type> vertexId = new ArrayList<>(2);
        vertexId.add(vertex1);
        vertexId.add(vertex2);
        edge.put(value.getKey(),vertexId);
    }

    /**
     * Удалить вершину.
     *
     * @param value объект
     */
    public void removeVertex(Type value) {
        vertex.remove(value.getKey());
    }
    /**
     * Удалить ребро.
     *
     * @param value объект
     */
    public void removeEdge(Type value) {
        edge.remove(value.getKey());
    }

    /**
     * Возвращает вершину, если она есть в графе.
     *
     * @param key ключ
     * @return объект, если нет, то null
     */
    public Type get(String key) {
        return vertex.get(key);
    }
}