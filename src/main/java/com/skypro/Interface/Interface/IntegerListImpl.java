package com.skypro.Interface.Interface;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] data;
    private int size = 0;
    private int index;
    private Integer item;

    public IntegerListImpl() {
        this.data = new Integer[]{};
    }

    public IntegerListImpl(Integer[] data) {
        this.data = data;
    }

    @Override
    public Integer add(Integer item) {
        return add(size, item);
    }

    @Override
    public Integer add(int index, Integer item) {
        checkItem(item);
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Неправильный индекс");
        }
        if (size + 1 > data.length) {
            grow();
        }
        System.arraycopy(this.data, index, this.data, index + 1, size - 1);
        this.data[index] = item;
        this.size++;
        return item;
    }

    private void grow() {
        this.data = Arrays.copyOf(this.data, this.data.length + 1);
    }

    @Override
    public Integer set(int index, Integer item) {
        checkIndex(index);
        checkItem(item);
        this.data[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        int elementIndex = indexOf(item);
        if (elementIndex == -1) {
            throw new IllegalArgumentException();
        }
        return remove(elementIndex);
    }

    @Override
    public Integer remove(int index) {
        int elementIndex = indexOf(index);
        if (elementIndex == -1) {
            throw new IllegalArgumentException();
        }
        return remove(elementIndex);
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        checkItem(item);
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkItem(item);
        int lastIndexOf = -1;
        for (int i = 0; i < size; i++) {
            if (item.equals(this.data[i])) {
                lastIndexOf = i;
            }
        }
        return lastIndexOf;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
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
    public Integer[] toArray() {
        return new Integer[0];
    }

    private void checkIndex(int index) {
        if (item == 0) {
            throw new IllegalArgumentException("Поле не может быть пустым");
        }
    }

    private void checkItem(Integer Value) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Неправильный индекс");
        }
    }

    public static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    private void sort (Integer[] array) {
        for (int i = 1; i<array.length;i++){
            int tmp = array[i];
            int j = i;
            while (j>0 && array [j-1] >= tmp) {
                array[j] = array[j - 1];
                j--;
            }
            array [j] = tmp;
            }
        }
    private int binarySearch (Integer[] array, int element) {
        int min = 0;
        int max = array.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (element == mid) {
                return mid;
            }
            if (element < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }

    }


