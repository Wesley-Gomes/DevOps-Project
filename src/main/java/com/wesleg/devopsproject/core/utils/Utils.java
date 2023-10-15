package com.wesleg.devopsproject.core.utils;

import java.lang.reflect.Field;

public class Utils {
   public static void updateObject(Object originalObject, Object updatedObject) {
      try {
         Class<?> clazz = originalObject.getClass();
         Field[] fields = clazz.getDeclaredFields();

         for (Field field : fields) {
            field.setAccessible(true);
            Object originalValue = field.get(originalObject);
            Object updatedValue = field.get(updatedObject);

            if (updatedValue != null && !updatedValue.equals(originalValue)) {
               field.set(originalObject, updatedValue);
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
