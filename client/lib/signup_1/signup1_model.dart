import '/backend/api_requests/api_calls.dart';
import '/flutter_flow/flutter_flow_theme.dart';
import '/flutter_flow/flutter_flow_util.dart';
import '/flutter_flow/flutter_flow_widgets.dart';
import 'signup1_widget.dart' show Signup1Widget;
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:provider/provider.dart';

class Signup1Model extends FlutterFlowModel<Signup1Widget> {
  ///  State fields for stateful widgets in this page.

  // State field(s) for InputEmail widget.
  FocusNode? inputEmailFocusNode;
  TextEditingController? inputEmailTextController;
  String? Function(BuildContext, String?)? inputEmailTextControllerValidator;
  // Stores action output result for [Backend Call - API (MailSend)] action in SendNumber widget.
  ApiCallResponse? apiResultlc4;
  // State field(s) for AuthNumber widget.
  FocusNode? authNumberFocusNode;
  TextEditingController? authNumberTextController;
  String? Function(BuildContext, String?)? authNumberTextControllerValidator;
  // Stores action output result for [Backend Call - API (MailAuth)] action in AuthButton widget.
  ApiCallResponse? apiResultkps;
  // State field(s) for InputPassword widget.
  FocusNode? inputPasswordFocusNode;
  TextEditingController? inputPasswordTextController;
  late bool inputPasswordVisibility;
  String? Function(BuildContext, String?)? inputPasswordTextControllerValidator;
  // State field(s) for CheckPassword widget.
  FocusNode? checkPasswordFocusNode;
  TextEditingController? checkPasswordTextController;
  late bool checkPasswordVisibility;
  String? Function(BuildContext, String?)? checkPasswordTextControllerValidator;

  @override
  void initState(BuildContext context) {
    inputPasswordVisibility = false;
    checkPasswordVisibility = false;
  }

  @override
  void dispose() {
    inputEmailFocusNode?.dispose();
    inputEmailTextController?.dispose();

    authNumberFocusNode?.dispose();
    authNumberTextController?.dispose();

    inputPasswordFocusNode?.dispose();
    inputPasswordTextController?.dispose();

    checkPasswordFocusNode?.dispose();
    checkPasswordTextController?.dispose();
  }
}
