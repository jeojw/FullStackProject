import '/backend/api_requests/api_calls.dart';
import '/flutter_flow/flutter_flow_theme.dart';
import '/flutter_flow/flutter_flow_util.dart';
import '/flutter_flow/flutter_flow_widgets.dart';
import 'auth_page_widget.dart' show AuthPageWidget;
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:provider/provider.dart';

class AuthPageModel extends FlutterFlowModel<AuthPageWidget> {
  ///  State fields for stateful widgets in this page.

  // State field(s) for InputEmail widget.
  FocusNode? inputEmailFocusNode;
  TextEditingController? inputEmailTextController;
  String? Function(BuildContext, String?)? inputEmailTextControllerValidator;
  // State field(s) for InnputPW widget.
  FocusNode? innputPWFocusNode;
  TextEditingController? inputPWTextController;
  late bool innputPWVisibility;
  String? Function(BuildContext, String?)? inputPWTextControllerValidator;
  // Stores action output result for [Backend Call - API (SignIn)] action in SiginButton widget.
  ApiCallResponse? apiResult8jy;

  @override
  void initState(BuildContext context) {
    innputPWVisibility = false;
  }

  @override
  void dispose() {
    inputEmailFocusNode?.dispose();
    inputEmailTextController?.dispose();

    innputPWFocusNode?.dispose();
    inputPWTextController?.dispose();
  }
}
