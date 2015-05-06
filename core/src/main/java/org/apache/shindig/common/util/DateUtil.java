/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.shindig.common.util;

import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class DateUtil {
  private static final DateTimeFormatter rfc1123DateFormat = DateTimeFormat
    .forPattern("EEE, dd MMM yyyy HH:mm:ss 'GMT'")
    .withLocale(Locale.JAPAN)
    .withZone(DateTimeZone.forID("Asia/Tokyo"));

  private static final DateTimeFormatter iso8601DateFormat = ISODateTimeFormat
    .dateTime()
    .withZone(DateTimeZone.forID("Asia/Tokyo"));

  private DateUtil() {
  }

  public static Date parseRfc1123Date(String dateStr) {
    try {
      return rfc1123DateFormat.parseDateTime(dateStr).toDate();
    } catch (Exception e) {
    }
    return null;
  }

  public static Date parseIso8601DateTime(String dateStr) {
    try {
      return new DateTime(dateStr).toDate();
    } catch (Exception e) {
    }
    return null;
  }

  public static String formatIso8601Date(Date date) {
    return formatIso8601Date(date.getTime());
  }

  public static String formatIso8601Date(long time) {
    return iso8601DateFormat.print(time);
  }

  public static String formatRfc1123Date(Date date) {
    return formatRfc1123Date(date.getTime());
  }

  public static String formatRfc1123Date(long timeStamp) {
    return rfc1123DateFormat.print(timeStamp);
  }
}