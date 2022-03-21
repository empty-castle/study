package com.intellij.database.types;

import com.intellij.database.model.DasUserDefinedType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface DasDefinedType extends DasType {
  @Nullable
  String getSchemaName();
  
  @Nullable
  String getPackageName();
  
  @NotNull
  String getName();
  
  @NotNull 
  DasUserDefinedType getDefinition();
}