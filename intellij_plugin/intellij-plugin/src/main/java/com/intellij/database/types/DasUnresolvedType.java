package com.intellij.database.types;

import org.jetbrains.annotations.NotNull;

public final class DasUnresolvedType implements DasType {
  private final String myText;

  public DasUnresolvedType(String text) {
    myText = text;
  }

  @NotNull
  public String getText() {
    return myText;
  }

  @NotNull
  @Override
  public String render() {
    return "<unresolved: " + getText() + ">";
  }
}
