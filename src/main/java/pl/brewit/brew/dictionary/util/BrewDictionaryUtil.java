package pl.brewit.brew.dictionary.util;

import java.util.HashMap;
import java.util.Map;

import static pl.brewit.brew.dictionary.util.BrewDictionaryConst.*;

public class BrewDictionaryUtil {

  private static Map<String, String> PRODUCT_PARAMETER_NAME_TO_UUID_MAP = new HashMap<>();
  private static Map<String, String> PRODUCT_PARAMETER_TYPE_TO_UUID_MAP = new HashMap<>();

  static {
    PRODUCT_PARAMETER_NAME_TO_UUID_MAP.put(TEMPERATURE, TEMP_UUID);
    PRODUCT_PARAMETER_NAME_TO_UUID_MAP.put(TIME, TIME_UUID);
    PRODUCT_PARAMETER_NAME_TO_UUID_MAP.put(WEIGHT, WEIGHT_UUID);

    PRODUCT_PARAMETER_TYPE_TO_UUID_MAP.put(COFFEE, COFFEE_UUID);
  }

  public static String getBasicProductParameterUUID(String parameterName) {
    return PRODUCT_PARAMETER_NAME_TO_UUID_MAP.get(parameterName);
  }

  public static String getBasicProductParameterTypeUUID(String parameterType) {
    return PRODUCT_PARAMETER_TYPE_TO_UUID_MAP.get(parameterType);
  }

}
