import 'package:flutter/material.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import '/backend/api_requests/api_manager.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'flutter_flow/flutter_flow_util.dart';
import 'dart:convert';

class FFAppState extends ChangeNotifier {
  static FFAppState _instance = FFAppState._internal();

  factory FFAppState() {
    return _instance;
  }

  FFAppState._internal();

  final FlutterSecureStorage _secureStorage = const FlutterSecureStorage();

  static void reset() {
    _instance = FFAppState._internal();
  }

  Future<void> saveToSecureStorage(String key, String value) async {
    await _secureStorage.write(key: key, value: value);
  }

  Future<String?> readFromSecureStorage(String key) async {
    return await _secureStorage.read(key: key);
  }

  Future<void> deleteFromSecureStorage(String key) async {
    await _secureStorage.delete(key: key);
  }

  Future<void> deleteAllFromSecureStorage() async {
    await _secureStorage.deleteAll();
  }

  Future initializePersistedState() async {}

  void update(VoidCallback callback) {
    callback();
    notifyListeners();
  }

  String _UserEmail = '';
  String get UserEmail => _UserEmail;
  set UserEmail(String value) {
    _UserEmail = value;
    saveToSecureStorage('userEmail', value);
  }

  String _UserPassword = '';
  String get UserPassword => _UserPassword;
  set UserPassword(String value) {
    _UserPassword = value;
    saveToSecureStorage('userPassword', value);
  }

  String _BirthText = '';
  String get BirthText => _BirthText;
  set BirthText(String value) {
    _BirthText = value;
  }

  int _Gender = 0;
  int get Gender => _Gender;
  set Gender(int value) {
    _Gender = value;
  }

  double _BMR = 0;
  double get BMR => _BMR;
  set BMR(double value) {
    _BMR = value;
  }

  int _Age = 0;
  int get Age => _Age;
  set Age(int value) {
    _Age = value;
  }

  double _Height = 0.0;
  double get Height => _Height;
  set Height(double value) {
    _Height = value;
  }

  double _Weight = 0.0;
  double get Weight => _Weight;
  set Weight(double value) {
    _Weight = value;
  }

  int _ActiveCoef = 0;
  int get ActiveCoef => _ActiveCoef;
  set ActiveCoef(int value) {
    _ActiveCoef = value;
  }

  String _MailType = '';
  String get MailType => _MailType;
  set MailType(String value) {
    _MailType = value;
  }

  String _AuthNum = '';
  String get AuthNum => _AuthNum;
  set AuthNum(String value) {
    _AuthNum = value;
    saveToSecureStorage('authNum', value);
  }

  List<dynamic> _DietList = [];
  List<dynamic> get DietList => _DietList;
  set DietList(List<dynamic> value) {
    _DietList = value;
  }

  void addToDietList(dynamic value) {
    DietList.add(value);
  }

  void removeFromDietList(dynamic value) {
    DietList.remove(value);
  }

  void removeAtIndexFromDietList(int index) {
    DietList.removeAt(index);
  }

  void updateDietListAtIndex(
    int index,
    dynamic Function(dynamic) updateFn,
  ) {
    DietList[index] = updateFn(_DietList[index]);
  }

  void insertAtIndexInDietList(int index, dynamic value) {
    DietList.insert(index, value);
  }

  String _NewPassword = '';
  String get NewPassword => _NewPassword;
  set NewPassword(String value) {
    _NewPassword = value;
    saveToSecureStorage('newPassword', value);
  }

  String _NutrientOption = '';
  String get NutrientOption => _NutrientOption;
  set NutrientOption(String value) {
    _NutrientOption = value;
  }

  String _SortOption = '';
  String get SortOption => _SortOption;
  set SortOption(String value) {
    _SortOption = value;
  }

  int _DietId = 0;
  int get DietId => _DietId;
  set DietId(int value) {
    _DietId = value;
  }

  dynamic _DietInfo;
  dynamic get DietInfo => _DietInfo;
  set DietInfo(dynamic value) {
    _DietInfo = value;
  }

  String _accessToken = '';
  String get accessToken => _accessToken;
  set accessToken(String value) {
    _accessToken = value;
    saveToSecureStorage('accessToken', value);
  }

  Future<void> loadAccessToken() async {
    _accessToken = (await readFromSecureStorage('accessToken')) ?? "";
  }

  String _refreshToken = '';
  String get refreshToken => _refreshToken;
  set refreshToken(String value) {
    _refreshToken = value;
    saveToSecureStorage('refreshToken', value);
  }

  Future<void> loadRefreshToken() async {
    _refreshToken = (await readFromSecureStorage('refreshToken')) ?? "";
  }
}
