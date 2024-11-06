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

  Future<String?> getUserEmail() async {
    return await readFromSecureStorage('userEmail');
  }

  Future<void> setUserEmail(String value) async {
    await saveToSecureStorage('userEmail', value);
  }

  Future<String?> getUserPassword() {
    return readFromSecureStorage('userPassword');
  }

  Future<void> setUserPassword(String value) async {
    await saveToSecureStorage('userPassword', value);
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

  Future<String?> getAuthNum() async {
    return await readFromSecureStorage('authNum');
  }

  Future<void> setAuthNum(String value) async {
    await saveToSecureStorage('authNum', value);
  }

  Future<void> deleteAuthNum() async {
    await deleteFromSecureStorage('authNum');
  }

  dynamic _DietList = [];
  dynamic get DietList => _DietList;
  set DietList(dynamic value) {
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

  Future<String?> getNewPassword() async {
    return await readFromSecureStorage('newPassword');
  }

  Future<void> setNewPassword (String value) async {
    await saveToSecureStorage('newPassword', value);
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

  Future<String?> getAccessToken() async {
    return await readFromSecureStorage('accessToken');
  }

  Future<void> setAccessToken(String value) async {
    await saveToSecureStorage('accessToken', value);
  }

  Future<String?> getRefreshToken() async {
    return await readFromSecureStorage('refreshToken');
  }

  Future<void> setRefreshToken(String value) async {
    await saveToSecureStorage('refreshToken', value);
  }
}
