package com.intellij.sql.database;

import com.intellij.database.model.DasDataSource;
import com.intellij.database.model.DasObject;
import com.intellij.database.psi.DbDataSource;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.sql.psi.SqlFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * @author gregsh
 */
public interface SqlDataSource extends DasDataSource {
  @Nullable
  DbDataSource getParentDataSource();

  void setName(@NotNull String name);

  @NotNull List<String> getUrls();

  void setUrls(@NotNull List<String> urls);

  @NotNull
  List<SqlFile> getSqlFiles();

  @NotNull
  List<VirtualFile> getRoots();

  boolean containsFile(@Nullable VirtualFile file);

  @Nullable
  DasObject fromModel(@Nullable DasObject delegate);

  boolean isReady();

  @Nullable
  String getCodeStyleName();

  void setCodeStyleName(@Nullable String codeStyleName);

  @NotNull Map<String, String> getScriptOptions();

  void setScriptOptions(@NotNull Map<String, String> scriptOptions);

  @Nullable
  String getOutputPath();

  @Nullable
  String getOutputLayout();
}
