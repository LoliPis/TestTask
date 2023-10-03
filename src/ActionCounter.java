import java.util.TreeMap;

/**
 * Класс ActionCounter используется для отслеживания количества действий,
 * выполненных в определенном временном интервале, и для получения количества
 * действий в этом интервале. Он поддерживает TreeMap для хранения меток времени
 * и соответствующего количества действий, выполненных на каждой метке времени.
 */
public class ActionCounter {
  private TreeMap<Integer, Integer> amountOfCallsInTimestamp;
  private final int FIVE_MIN_IN_SEC = 300;

  /**
   * Инициализирует новый объект ActionCounter с пустым TreeMap для хранения обращений.
   */
  public ActionCounter() {
    amountOfCallsInTimestamp = new TreeMap<>();
  }


  /**
   * Записывает обращение в указанной метке времени.
   * Одновременно может произойти несколько попаданий timestamp.
   *
   * @param timestamp Метка времени, когда произошло обращение.
   */
  public void call(int timestamp) {
    amountOfCallsInTimestamp.merge(timestamp, 1, Integer::sum);
  }

  /**
   * Получает количество обращений, выполненных за последние пять минут (т. е. за последние 300 секунд),
   * заканчивающиеся в заданной метке времени timestamp.
   *
   * @param timestamp Метка времени, завершающая временной отрезок в 5 минут.
   * @return Количество обращений, выполненных в указанном временном отрезке.
   */
  public int getActions(int timestamp) {
    return getActionsUntil(timestamp);
  }

  /**
   * Получает общее количество обращений, выполненных от (не включительно) и до (включительно) указанной метки времени.
   *
   * @param timestamp Метка времени, до которой необходимо получить суммарное число обращений.
   * @return Общее количество действий, выполненных от (не включительно) и до (включительно) указанной метки времени.
   */
  private int getActionsUntil(int timestamp) {
    return amountOfCallsInTimestamp
        .subMap(timestamp - FIVE_MIN_IN_SEC, false, timestamp, true)
        .values()
        .stream()
        .mapToInt(Integer::intValue)
        .sum();
  }
}
