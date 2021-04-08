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
package com.dtstack.flinkx.connectors.kafka.conf;

import com.dtstack.flinkx.conf.FlinkxCommonConf;
import com.dtstack.flinkx.connectors.kafka.enums.FormatType;
import com.dtstack.flinkx.connectors.kafka.enums.StartupMode;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Reason:
 * Date: 2018/09/18
 * Company: www.dtstack.com
 *
 * @author sishu.yss
 */

public class KafkaConf extends FlinkxCommonConf {

    /** kafka地址 */
    private String bootstrapServers;
    /** source 读取数据的格式 */
    private String codec = "text";
    /** kafka topic */
    private String topic;
    /** 是否开启topic正则匹配 */
    private Boolean topicIsPattern = false;
    /** 默认需要一个groupId */
    private String groupId = UUID.randomUUID().toString().replace("-", "");
    /** kafka启动模式 */
    private StartupMode mode = StartupMode.GROUP_OFFSETS;
    /** 消费位置,partition:0,offset:42;partition:1,offset:300 */
    private String offset = "";
    /** 当消费位置为TIMESTAMP时该参数设置才有效 */
    private long timestamp = -1L;
    /** kafka其他原生参数 */
    private Map<String, String> consumerSettings;
    /** 数据格式的类型 */
    private String sourceDataType = FormatType.DT_NEST.name();
    /** sourceDataType为csv时才生效 */
    private String schemaInfo;
    /** csv字段默认分隔符 */
    private String fieldDelimiter = ",";
    /**kafka地址*/
    private String brokerList;
    /**是否开启按照key分区写入partition*/
    private String enableKeyPartition;
    /**对应的enableKeyPartition的key*/
    private String partitionKeys;
    /**kafka其他原生参数*/
    private Map<String, String> producerSettings;
    /**字段映射配置。从reader插件传递到writer插件的的数据只包含其value属性，配置该参数后可将其还原成键值对类型json字符串输出。*/
    private List<String> tableFields;
    /**结果数据的写入方式*/
    private String sinkDataType = FormatType.JSON.name();

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Boolean getTopicIsPattern() {
        return topicIsPattern;
    }

    public void setTopicIsPattern(Boolean topicIsPattern) {
        this.topicIsPattern = topicIsPattern;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public StartupMode getMode() {
        return mode;
    }

    public void setMode(StartupMode mode) {
        this.mode = mode;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, String> getConsumerSettings() {
        return consumerSettings;
    }

    public void setConsumerSettings(Map<String, String> consumerSettings) {
        this.consumerSettings = consumerSettings;
    }

    public String getSourceDataType() {
        return sourceDataType;
    }

    public void setSourceDataType(String sourceDataType) {
        this.sourceDataType = sourceDataType;
    }

    public String getSchemaInfo() {
        return schemaInfo;
    }

    public void setSchemaInfo(String schemaInfo) {
        this.schemaInfo = schemaInfo;
    }

    public String getFieldDelimiter() {
        return fieldDelimiter;
    }

    public void setFieldDelimiter(String fieldDelimiter) {
        this.fieldDelimiter = fieldDelimiter;
    }

    public String getBrokerList() {
        return brokerList;
    }

    public void setBrokerList(String brokerList) {
        this.brokerList = brokerList;
    }

    public String getEnableKeyPartition() {
        return enableKeyPartition;
    }

    public void setEnableKeyPartition(String enableKeyPartition) {
        this.enableKeyPartition = enableKeyPartition;
    }

    public String getPartitionKeys() {
        return partitionKeys;
    }

    public void setPartitionKeys(String partitionKeys) {
        this.partitionKeys = partitionKeys;
    }

    public Map<String, String> getProducerSettings() {
        return producerSettings;
    }

    public void setProducerSettings(Map<String, String> producerSettings) {
        this.producerSettings = producerSettings;
    }

    public List<String> getTableFields() {
        return tableFields;
    }

    public void setTableFields(List<String> tableFields) {
        this.tableFields = tableFields;
    }

    public String getSinkDataType() {
        return sinkDataType;
    }

    public void setSinkDataType(String sinkDataType) {
        this.sinkDataType = sinkDataType;
    }

    @Override
    public String toString() {
        return "KafkaConf{" +
                "bootstrapServers='" + bootstrapServers + '\'' +
                ", codec='" + codec + '\'' +
                ", topic='" + topic + '\'' +
                ", topicIsPattern=" + topicIsPattern +
                ", groupId='" + groupId + '\'' +
                ", mode=" + mode +
                ", offset='" + offset + '\'' +
                ", timestamp=" + timestamp +
                ", consumerSettings=" + consumerSettings +
                ", sourceDataType='" + sourceDataType + '\'' +
                ", schemaInfo='" + schemaInfo + '\'' +
                ", fieldDelimiter='" + fieldDelimiter + '\'' +
                ", brokerList='" + brokerList + '\'' +
                ", enableKeyPartition='" + enableKeyPartition + '\'' +
                ", partitionKeys='" + partitionKeys + '\'' +
                ", producerSettings=" + producerSettings +
                ", tableFields=" + tableFields +
                ", sinkDataType='" + sinkDataType + '\'' +
                '}';
    }
}
