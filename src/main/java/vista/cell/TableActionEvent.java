package main.java.vista.cell;

public interface TableActionEvent {
    public void onEdit(int row);
    public void onDelete(int row);
    public void onView(int row);
}
