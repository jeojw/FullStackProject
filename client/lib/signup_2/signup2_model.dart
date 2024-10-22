import '/backend/api_requests/api_calls.dart';
import '/flutter_flow/flutter_flow_drop_down.dart';
import '/flutter_flow/flutter_flow_theme.dart';
import '/flutter_flow/flutter_flow_util.dart';
import '/flutter_flow/flutter_flow_widgets.dart';
import '/flutter_flow/form_field_controller.dart';
import '/flutter_flow/custom_functions.dart' as functions;
import 'signup2_widget.dart' show Signup2Widget;
import 'package:expandable/expandable.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:provider/provider.dart';

class Signup2Model extends FlutterFlowModel<Signup2Widget> {
  ///  State fields for stateful widgets in this page.

  // State field(s) for SetGender widget.
  String? setGenderValue;
  FormFieldController<String>? setGenderValueController;
  DateTime? datePicked;
  // State field(s) for Height widget.
  FocusNode? heightFocusNode;
  TextEditingController? heightTextController;
  String? Function(BuildContext, String?)? heightTextControllerValidator;
  // State field(s) for Weight widget.
  FocusNode? weightFocusNode;
  TextEditingController? weightTextController;
  String? Function(BuildContext, String?)? weightTextControllerValidator;
  // State field(s) for Slider widget.
  double? sliderValue;
  // State field(s) for Expandable widget.
  late ExpandableController expandableExpandableController;

  // Stores action output result for [Backend Call - API (SingUp)] action in Button widget.
  ApiCallResponse? apiResulthgg;

  @override
  void initState(BuildContext context) {}

  @override
  void dispose() {
    heightFocusNode?.dispose();
    heightTextController?.dispose();

    weightFocusNode?.dispose();
    weightTextController?.dispose();

    expandableExpandableController.dispose();
  }
}
