import '/backend/api_requests/api_calls.dart';
import '/flutter_flow/flutter_flow_theme.dart';
import '/flutter_flow/flutter_flow_util.dart';
import '/flutter_flow/flutter_flow_widgets.dart';
import 'find_password_widget.dart' show FindPasswordWidget;
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:provider/provider.dart';

class FindPasswordModel extends FlutterFlowModel<FindPasswordWidget> {
  ///  State fields for stateful widgets in this page.

  // State field(s) for EmailField widget.
  FocusNode? emailFieldFocusNode;
  TextEditingController? emailFieldTextController;
  String? Function(BuildContext, String?)? emailFieldTextControllerValidator;
  // Stores action output result for [Backend Call - API (MailSend)] action in CheckButton widget.
  ApiCallResponse? apiResultiww;
  // State field(s) for AuthNumberField widget.
  FocusNode? authNumberFieldFocusNode;
  TextEditingController? authNumberFieldTextController;
  String? Function(BuildContext, String?)?
      authNumberFieldTextControllerValidator;
  // Stores action output result for [Backend Call - API (MailAuth)] action in CheckButton widget.
  ApiCallResponse? apiResultgpo;

  @override
  void initState(BuildContext context) {}

  @override
  void dispose() {
    emailFieldFocusNode?.dispose();
    emailFieldTextController?.dispose();

    authNumberFieldFocusNode?.dispose();
    authNumberFieldTextController?.dispose();
  }
}
