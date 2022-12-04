package com.skypro.Interface.Interface;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String [] data;
    private int size = 0;
    private int index;
    private String item;

    public StringListImpl() {
        this.data = new String[]{};
    }

    @Override
    public String add(String item) {
        return add(size,item);
    }

    @Override
    public String add(int index, String item) {
        checkItem(item);
        if (index<0 || index>size) {
            throw new IllegalArgumentException("Неправильный индекс");
        }
        if (size+1 > data.length){
            grow();
        }
        System.arraycopy(this.data, index,this.data, index+1,size-1);
        this.data[index]=item;
        this.size++;
        return item;
    }

    private void grow() {
        this.data = Arrays.copyOf(this.data, this.data.length + 1);
    }

    @Override
    public String set(int index, String item) {
        checkIndex(index);
        checkItem(item);
        this.data[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int elementIndex = indexOf(item);
        if (elementIndex == -1) {
            throw new IllegalArgumentException();
        }
        return remove(elementIndex);
    }

    @Override
    public String remove(int index) {
        int elementIndex = checkIndex(index);
        if (elementIndex == -1) {
            throw new IllegalArgumentException();
        }
        return remove(elementIndex);
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item)!=-1;
    }

    @Override
    public int indexOf(String item) {
        checkItem(item);
       for (int i = 0; i < size; i++){
           if (data[i].equals(item)){
               return i;}
           }
       return -1;
       }

    @Override
    public int lastIndexOf(String item) {
        checkItem(item);
        int lastIndexOf = -1;
        for(int i =0; i < size; i++) {
            if(item.equals(this.data[i])) {
                lastIndexOf = i;
            }
        }
        return lastIndexOf;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(),otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return new String[0];
    }
    private int checkIndex (int index) {
        if (item == null) {
            throw new IllegalArgumentException("Поле не может быть пустым");
        }
        return index;
    }
    private void checkItem(String Value) {
        if (index<0|| index>=size) {
            throw new IllegalArgumentException("Неправильный индекс");
        }
    }
}
