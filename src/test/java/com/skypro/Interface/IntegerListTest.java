package com.skypro.Interface;

import com.skypro.Interface.Interface.IntegerList;
import com.skypro.Interface.Interface.IntegerListImpl;
import com.skypro.Interface.Interface.StringListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.xml.crypto.Data;

@ExtendWith(MockitoExtension.class)
public class IntegerListTest {

    @Mock
    IntegerList integerList;

    @InjectMocks
    IntegerListImpl integerListImpl;

    @BeforeEach
    public void setUp(){
        this.integerList = new IntegerListImpl();
    }

    }

