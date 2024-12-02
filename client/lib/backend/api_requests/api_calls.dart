import 'dart:convert';
import 'dart:typed_data';
import 'package:flutter/foundation.dart';

import '/flutter_flow/flutter_flow_util.dart';
import 'api_manager.dart';

export 'api_manager.dart' show ApiCallResponse;

const _kPrivateApiFunctionName = 'ffPrivateApiCall';

class GetInfoDataCall {
  static Future<ApiCallResponse> call() async {
    final userEmail = await FFAppState().getUserEmail();
    final userPassword = await FFAppState().getUserPassword();
    final accessToken = await FFAppState().getAccessToken();

    final ffApiRequestBody = '''
{
  "userEmail": "$userEmail",
  "userPassword": "$userPassword"
}''';
    return ApiManager.instance.makeApiCall(
      callName: 'GetInfoData',
      apiUrl: 'http://43.201.184.6:8080/api/getUserInfo',
      callType: ApiCallType.POST,
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer $accessToken'
      },
      params: {},
      body: ffApiRequestBody,
      bodyType: BodyType.JSON,
      returnBody: true,
      encodeBodyUtf8: true,
      decodeUtf8: true,
      cache: false,
      isStreamingApi: false,
      alwaysAllowBody: false,
    );
  }
}

class SignInCall {
  static Future<ApiCallResponse> call() async {
    final userEmail = await FFAppState().getUserEmail();
    final userPassword = await FFAppState().getUserPassword();
    final ffApiRequestBody = '''
{
  "userEmail": "$userEmail",
  "userPassword": "$userPassword"
}''';
    return ApiManager.instance.makeApiCall(
      callName: 'SignIn',
      apiUrl: 'http://43.201.184.6:8080/api/signIn',
      callType: ApiCallType.POST,
      headers: {
        'Content-Type': 'application/json',
      },
      params: {},
      body: ffApiRequestBody,
      bodyType: BodyType.JSON,
      returnBody: true,
      encodeBodyUtf8: true,
      decodeUtf8: true,
      cache: false,
      isStreamingApi: false,
      alwaysAllowBody: false,
    );
  }
}

class SetOptionCall {
  static Future<ApiCallResponse> call() async {
    final userEmail = await FFAppState().getUserEmail();
    final gender = FFAppState().Gender;
    final birthText = FFAppState().BirthText;
    final height = FFAppState().Height;
    final weight = FFAppState().Weight;
    final activeCoef = FFAppState().ActiveCoef;
    final accessToken = await FFAppState().getAccessToken();
    final ffApiRequestBody = '''
{
  "userEmail": "$userEmail",
  "gender": "$gender",
  "birth": "$birthText",
  "height": "$height",
  "weight": "$weight",
  "activeCoef": "$activeCoef"
}''';
    return ApiManager.instance.makeApiCall(
      callName: 'SetOption',
      apiUrl: 'http://43.201.184.6:8080/api/setOption',
      callType: ApiCallType.POST,
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer $accessToken'
      },
      params: {},
      body: ffApiRequestBody,
      bodyType: BodyType.JSON,
      returnBody: true,
      encodeBodyUtf8: true,
      decodeUtf8: true,
      cache: false,
      isStreamingApi: false,
      alwaysAllowBody: false,
    );
  }
}

class SingUpCall {
  static Future<ApiCallResponse> call() async {
    final userEmail = await FFAppState().getUserEmail();
    final userPassword = await FFAppState().getUserPassword();
    final gender = FFAppState().Gender;
    final birthText = FFAppState().BirthText;
    final height = FFAppState().Height;
    final weight = FFAppState().Weight;
    final activeCoef = FFAppState().ActiveCoef;
    final dietList = [];

    final ffApiRequestBody = '''
{
  "userEmail": "$userEmail",
  "userPassword": "$userPassword",
  "gender": "$gender",
  "birth": "$birthText",
  "height": "$height",
  "weight": "$weight",
  "activeCoef": "$activeCoef",
  "dietList": $dietList
}''';
    return ApiManager.instance.makeApiCall(
      callName: 'SingUp',
      apiUrl: 'http://43.201.184.6:8080/api/signUp',
      callType: ApiCallType.POST,
      headers: {
        'Content-Type': 'application/json',
      },
      params: {},
      body: ffApiRequestBody,
      bodyType: BodyType.JSON,
      returnBody: true,
      encodeBodyUtf8: true,
      decodeUtf8: true,
      cache: false,
      isStreamingApi: false,
      alwaysAllowBody: false,
    );
  }
}

class MailSendCall {
  static Future<ApiCallResponse> call() async {
    final userEmail = await FFAppState().getUserEmail();
    final mailType = FFAppState().MailType;

    final ffApiRequestBody = '''
{
  "email": "$userEmail",
  "type": "$mailType"
}''';
    return ApiManager.instance.makeApiCall(
      callName: 'MailSend',
      apiUrl: 'http://43.201.184.6:8080/api/mailSend',
      callType: ApiCallType.POST,
      headers: {
        'Content-Type': 'application/json',
      },
      params: {},
      body: ffApiRequestBody,
      bodyType: BodyType.JSON,
      returnBody: true,
      encodeBodyUtf8: true,
      decodeUtf8: true,
      cache: false,
      isStreamingApi: false,
      alwaysAllowBody: false,
    );
  }
}

class MailAuthCall {
  static Future<ApiCallResponse> call() async {
    final userEmail = await FFAppState().getUserEmail();
    final authNum = await FFAppState().readFromSecureStorage('authNum');

    final ffApiRequestBody = '''
{
  "email": "$userEmail",
  "authNum": "$authNum"
}''';
    return ApiManager.instance.makeApiCall(
      callName: 'MailAuth',
      apiUrl: 'http://43.201.184.6:8080/api/mailAuthCheck',
      callType: ApiCallType.POST,
      headers: {
        'Content-Type': 'application/json',
      },
      params: {},
      body: ffApiRequestBody,
      bodyType: BodyType.JSON,
      returnBody: true,
      encodeBodyUtf8: true,
      decodeUtf8: true,
      cache: false,
      isStreamingApi: false,
      alwaysAllowBody: false,
    );
  }
}

class GetDietListCall {
  static Future<ApiCallResponse> call() async {
    final userEmail = await FFAppState().getUserEmail();
    final accessToken = await FFAppState().getAccessToken();

    return ApiManager.instance.makeApiCall(
      callName: 'GetDietLists',
      apiUrl: 'http://43.201.184.6:8080/api/getDietList?userEmail=$userEmail',
      callType: ApiCallType.POST,
      headers: {
        'Authorization': 'Bearer $accessToken',
        'Content-Type': 'application/json'
      },
      params: {},
      returnBody: true,
      encodeBodyUtf8: true,
      decodeUtf8: true,
      cache: false,
      isStreamingApi: false,
      alwaysAllowBody: false,
    );
  }
}

class SearchDietListsCall {
  static Future<ApiCallResponse> call() async {
    final userEmail = await FFAppState().getUserEmail();
    final BMR = FFAppState().BMR;
    final activeCoef = FFAppState().ActiveCoef;
    final accessToken = await FFAppState().getAccessToken();

    final ffApiRequestBody = '''
{
  "userEmail": "$userEmail",
  "bmr": "$BMR",
  "activeCoef": "$activeCoef"
}''';
    return ApiManager.instance.makeApiCall(
      callName: 'SearchDietLists',
      apiUrl: 'http://43.201.184.6:8080/api/searchDietList',
      callType: ApiCallType.POST,
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer $accessToken'
      },
      params: {},
      body: ffApiRequestBody,
      bodyType: BodyType.JSON,
      returnBody: true,
      encodeBodyUtf8: true,
      decodeUtf8: true,
      cache: false,
      isStreamingApi: false,
      alwaysAllowBody: false,
    );
  }
}

class ChangePasswordCall {
  static Future<ApiCallResponse> call() async {
    final userEmail = await FFAppState().getUserEmail();
    final newPassword = await FFAppState().getNewPassword();

    final ffApiRequestBody = '''
{
  "userEmail": "$userEmail",
  "newPassword": "$newPassword"
}''';
    return ApiManager.instance.makeApiCall(
      callName: 'ChangePassword',
      apiUrl: 'http://43.201.184.6:8080/api/changePassword',
      callType: ApiCallType.POST,
      headers: {
        'Content-Type': 'application/json',
      },
      params: {},
      body: ffApiRequestBody,
      bodyType: BodyType.JSON,
      returnBody: true,
      encodeBodyUtf8: true,
      decodeUtf8: true,
      cache: false,
      isStreamingApi: false,
      alwaysAllowBody: false,
    );
  }
}

class SortDietListCall {
  static Future<ApiCallResponse> call() async {
    final userEmail = await FFAppState().getUserEmail();
    final dietList = FFAppState().DietList;
    final nutrientOption = FFAppState().NutrientOption;
    final sortOption = FFAppState().SortOption;
    final accessToken = await FFAppState().getAccessToken();

    final ffApiRequestBody = '''
{
  "userEmail": "$userEmail", 
  "dietList": ${jsonEncode(dietList)},
  "nutrient": "$nutrientOption",
  "sortOption": "$sortOption"
}''';
    return ApiManager.instance.makeApiCall(
      callName: 'SortDietList',
      apiUrl: 'http://43.201.184.6:8080/api/sortDietList',
      callType: ApiCallType.POST,
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer $accessToken'
      },
      params: {},
      body: ffApiRequestBody,
      bodyType: BodyType.JSON,
      returnBody: true,
      encodeBodyUtf8: true,
      decodeUtf8: true,
      cache: false,
      isStreamingApi: false,
      alwaysAllowBody: false,
    );
  }
}

class GetDietInfoCall {
  static Future<ApiCallResponse> call({
    required int? id,
  }) async {
    final accessToken = await FFAppState().getAccessToken();

    return ApiManager.instance.makeApiCall(
      callName: 'GetDietInfo',
      apiUrl: 'http://43.201.184.6:8080/api/dietInfo/${id.toString()}',
      callType: ApiCallType.GET,
      headers: {'Authorization': 'Bearer $accessToken'},
      params: {},
      returnBody: true,
      encodeBodyUtf8: true,
      decodeUtf8: true,
      cache: false,
      isStreamingApi: false,
      alwaysAllowBody: false,
    );
  }
}

class SearchDietListsByOptionCall {
  static Future<ApiCallResponse> call() async {
    final userEmail = await FFAppState().getUserEmail();
    final accessToken = await FFAppState().getAccessToken();
    final rice = FFAppState().searchRice;
    final soup = FFAppState().searchSoup;
    final sideDish = FFAppState().searchSideDish;
    final ffApiRequestBody = '''
{
  "userEmail": "$userEmail", 
  "searchRice": "$rice",
  "searchSoup": "$soup",
  "searchSideDish": "$sideDish"
}''';

    return ApiManager.instance.makeApiCall(
      callName: 'SearchDietByOptions',
      apiUrl: 'http://43.201.184.6:8080/api/searchDietListByOption',
      callType: ApiCallType.POST,
      headers: {
        'Authorization': 'Bearer $accessToken',
        'Content-Type': 'application/json',
      },
      params: {},
      body: ffApiRequestBody,
      bodyType: BodyType.JSON,
      returnBody: true,
      encodeBodyUtf8: true,
      decodeUtf8: true,
      cache: false,
      isStreamingApi: false,
      alwaysAllowBody: false,
    );
  }
}

class ApiPagingParams {
  int nextPageNumber = 0;
  int numItems = 0;
  dynamic lastResponse;

  ApiPagingParams({
    required this.nextPageNumber,
    required this.numItems,
    required this.lastResponse,
  });

  @override
  String toString() =>
      'PagingParams(nextPageNumber: $nextPageNumber, numItems: $numItems, lastResponse: $lastResponse,)';
}

String _toEncodable(dynamic item) {
  return item;
}

String _serializeList(List? list) {
  list ??= <String>[];
  try {
    return json.encode(list, toEncodable: _toEncodable);
  } catch (_) {
    if (kDebugMode) {
      print("List serialization failed. Returning empty list.");
    }
    return '[]';
  }
}

String _serializeJson(dynamic jsonVar, [bool isList = false]) {
  jsonVar ??= (isList ? [] : {});
  try {
    return json.encode(jsonVar, toEncodable: _toEncodable);
  } catch (_) {
    if (kDebugMode) {
      print("Json serialization failed. Returning empty json.");
    }
    return isList ? '[]' : '{}';
  }
}
