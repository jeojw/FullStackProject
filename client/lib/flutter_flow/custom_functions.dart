import 'dart:convert';
import 'dart:math' as math;

import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:intl/intl.dart';
import 'package:timeago/timeago.dart' as timeago;
import 'lat_lng.dart';
import 'place.dart';
import 'uploaded_file.dart';

int convertToInt(double value) {
  return value.round();
}

int? genderConvenrToInt(String? gender) {
  if (gender == "Male") {
    return 1;
  } else {
    return 2;
  }
}

String? genderConverToString(int? genderInt) {
  if (genderInt == 1) {
    return 'Male';
  } else {
    return 'Female';
  }
}
