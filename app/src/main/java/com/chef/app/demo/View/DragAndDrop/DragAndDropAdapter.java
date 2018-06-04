package com.chef.app.demo.View.DragAndDrop;

public interface DragAndDropAdapter {
    void onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
