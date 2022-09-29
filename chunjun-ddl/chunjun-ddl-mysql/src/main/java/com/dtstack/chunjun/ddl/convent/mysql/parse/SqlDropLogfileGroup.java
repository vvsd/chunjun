/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dtstack.chunjun.ddl.convent.mysql.parse;

import com.google.common.collect.ImmutableList;
import org.apache.calcite.sql.SqlDrop;
import org.apache.calcite.sql.SqlIdentifier;
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.sql.SqlLiteral;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.SqlOperator;
import org.apache.calcite.sql.SqlSpecialOperator;
import org.apache.calcite.sql.SqlWriter;
import org.apache.calcite.sql.parser.SqlParserPos;

import javax.annotation.Nonnull;

import java.util.List;

/** Parse tree for {@code DROP VIEW} statement. */
public class SqlDropLogfileGroup extends SqlDrop {
    private static final SqlOperator OPERATOR =
            new SqlSpecialOperator("DROP LOGFILE GROUP", SqlKind.DROP_VIEW);

    public SqlIdentifier name;
    private final SqlLiteral engineName;

    public SqlDropLogfileGroup(SqlParserPos pos, SqlIdentifier name, SqlLiteral engineName) {
        super(OPERATOR, pos, false);
        this.name = name;
        this.engineName = engineName;
    }

    @Override
    @Nonnull
    public List<SqlNode> getOperandList() {
        return ImmutableList.of(this.name, this.engineName);
    }

    public void unparse(SqlWriter writer, int leftPrec, int rightPrec) {
        writer.keyword(this.getOperator().getName());
        name.unparse(writer, leftPrec, rightPrec);
        if (engineName != null) {
            writer.print("ENGINE");
            writer.print("=");
            engineName.unparse(writer, leftPrec, rightPrec);
        }
    }
}
