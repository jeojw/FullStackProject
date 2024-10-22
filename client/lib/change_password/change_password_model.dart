import '/backend/api_requests/api_calls.dart';
import '/flutter_flow/flutter_flow_theme.dart';
import '/flutter_flow/flutter_flow_util.dart';
import '/flutter_flow/flutter_flow_widgets.dart';
import 'change_password_widget.dart' show ChangePasswordWidget;
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:provider/provider.dart';

class ChangePasswordModel extends FlutterFlowModel<ChangePasswordWidget> {
  ///  State fields for stateful widgets in this page.

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
  // Stores action output result for [Backend Call - API (ChangePassword)] action in Button widget.
  ApiCallResponse? apiResult477;

  @override
  void initState(BuildContext context) {
    inputPasswordVisibility = false;
    checkPasswordVisibility = false;
  }

  @override
  void dispose() {
    inputPasswordFocusNode?.dispose();
    inputPasswordTextController?.dispose();

    checkPasswordFocusNode?.dispose();
    checkPasswordTextController?.dispose();
  }
}
