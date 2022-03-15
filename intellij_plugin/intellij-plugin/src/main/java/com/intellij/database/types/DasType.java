package com.intellij.database.types;

import org.jetbrains.annotations.NotNull;

public interface DasType {
  @NotNull DasType UNKNOWN = new DasType() {
    @NotNull
    @Override
    public String render() {
      return "<unknown>";
    }
  };

  @NotNull DasType VOID = new DasType() {
    @NotNull
    @Override
    public String render() {
      return "<void>";
    }
  };

  @NotNull DasType NULL = new DasType() {
    @NotNull
    @Override
    public String render() {
      return "<null>";
    }
  };

  @NotNull String render();
}