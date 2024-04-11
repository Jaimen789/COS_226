public class QNode {
    volatile boolean locked = false;
    QNode next = null;
}
