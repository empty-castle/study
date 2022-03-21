package com.intellij.database.types;

import com.intellij.database.model.DataType;
import org.jetbrains.annotations.NotNull;

public interface DasBuiltinType extends DasType {
  enum Kind {
    NUMBER,
    BOOLEAN,
    DATE,
    TIME,
    DATE_TIME,
    TIMESTAMP,
    INTERVAL,
    STRING,
    BINARY,
    MISC
  }
  
  @NotNull
  Kind getKind();
  
  @NotNull
  String getName();

  @NotNull DataType toDataType();
}
