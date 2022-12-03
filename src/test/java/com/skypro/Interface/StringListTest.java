package com.skypro.Interface;

import com.skypro.Interface.Interface.StringList;
import com.skypro.Interface.Interface.StringListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StringListTest {

    @Mock
    StringList stringList;

    @InjectMocks
    StringListImpl stringListImpl;

    @BeforeEach
    public void setUp(){
        this.stringList = new StringListImpl();
    }

    @Test
    public void whenItemAddedThanItCanBeFoundItList (){
        this.stringList.add("Тест");
        Assertions.assertEquals(1,this.stringList.size());
    }
    @Test
    public void whenItemAddedToSpecificIndexThenElementsIsShiftedRight(){
        this.stringList.add("Тест");
        this.stringList.add(0,"Тест1");
        Assertions.assertEquals(2,this.stringList.size());
        Assertions.assertEquals("Тест1",this.stringList.get(0));
        Assertions.assertEquals("Тест",this.stringList.get(1));
    }
    @Test
    public void whenValueIsSetWhenGetFReturnsThisValue(){
        this.stringList.add("Тест");
        this.stringList.add("Тест1");
        this.stringList.add("Тест2");
        this.stringList.set(1,"new value" );
        Assertions.assertEquals(3,this.stringList.size());
        Assertions.assertEquals("new value",this.stringList.get(1));
    }
    @Test
    public void whenTwoElementsAddedToListThanReturnsFirst(){
        this.stringList.add("Тест");
        this.stringList.add("Тест1");
        Assertions.assertEquals(0,this.stringList.indexOf("Тест"));
    }
    @Test
    public void whenTwoElementsAddedToListUnknownReturnsMinusOne(){
        this.stringList.add("Тест");
        this.stringList.add("Тест1");
        Assertions.assertEquals(-1,this.stringList.indexOf("Тест78675645"));
    }
    @Test

    public void whenTwoElementsAddedToListThenLastIndexOfReturnsSecond(){
        this.stringList.add("Тест");
        this.stringList.add("Тест1");
        Assertions.assertEquals(1,this.stringList.indexOf("Тест78675645"));
    }
    @Test
    public void whenTwoElementsAddedToListThenLastIndexOfUnknownReturnsMinusOne() {
        this.stringList.add("Тест");
        this.stringList.add("Тест1");
        Assertions.assertEquals(-1, this.stringList.indexOf("Тест78675645"));
    }
}
