/*
 * Copyright © 2019 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package co.cask.cdc.plugins.source.sqlserver;

import co.cask.cdap.api.annotation.Description;
import co.cask.cdap.api.annotation.Macro;
import co.cask.cdap.api.annotation.Name;
import co.cask.cdap.api.plugin.PluginConfig;
import co.cask.cdc.plugins.common.CDCReferencePluginConfig;

import javax.annotation.Nullable;

/**
 * Defines the {@link PluginConfig} for the {@link CTSQLServer}.
 */
public class CTSQLServerConfig extends CDCReferencePluginConfig {

  public static final String CONNECTION_STRING = "connectionString";
  public static final String USERNAME = "username";
  public static final String PASSWORD = "password";
  public static final String DBNAME = "dbname";
  public static final String SQN = "sqn";
  public static final String CDCNUMBER = "cdcnumber";
  public static final String TABLENAME = "tableName";

  @Name(CONNECTION_STRING)
  @Description("Connection String")
  @Macro
  private String connectionString;

  @Name(USERNAME)
  @Description("User to use to connect to the specified database. Required for databases that " +
    "need authentication. Optional for databases that do not require authentication.")
  @Nullable
  @Macro
  private final String username;

  @Name(DBNAME)
  @Description("Database Name")
  public String dbName;

  @Name(PASSWORD)
  @Description("Password to use to connect to the specified database. Required for databases that " +
    "need authentication. Optional for databases that do not require authentication.")
  @Nullable
  @Macro
  private final String password;

  @Name(SQN)
  @Description("Need the CDC Sequence Number in the output schema")
  @Nullable
  @Macro
  private final Boolean sqn;


  @Name(CDCNUMBER)
  @Description("CDC Sequence Number to start ingesting from")
  @Nullable
  @Macro
  private final int cdcnumber;


  @Name(TABLENAME)
  @Description("Table name for CT Information")
  @Nullable
  @Macro
  private final String tableName;


  public CTSQLServerConfig() {
    super("");
    username = null;
    password = null;
    sqn = false;
    cdcnumber = 0;
    tableName = null;
  }

  public CTSQLServerConfig(String referenceName, String hostname, int port, String dbName, String username,
                           String password, Boolean sqn, int cdcnumber, String tableName) {
    super(referenceName);
    this.connectionString = hostname;
    this.username = username;
    this.password = password;
    this.sqn = sqn;
    this.cdcnumber = cdcnumber;
    this.tableName = tableName;
  }

  public String getConnectionString() {
    return connectionString;
  }

  public String getDbName() {
        return dbName;
  }

  @Nullable
  public String getUsername() {
    return username;
  }

  @Nullable
  public String getPassword() {
    return password;
  }

  @Nullable
  public Boolean getSqn() {
    return sqn;
  }

  @Nullable
  public int getCdcnumber() {
    return cdcnumber;
  }

  @Nullable
  public String getTableName() {
    return tableName;
  }

  @Override
  public void validate() {
    super.validate();
  }
}
