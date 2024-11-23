import '/backend/api_requests/api_calls.dart';
import '/flutter_flow/flutter_flow_data_table.dart';
import '/flutter_flow/flutter_flow_drop_down.dart';
import '/flutter_flow/flutter_flow_theme.dart';
import '/flutter_flow/flutter_flow_util.dart';
import '/flutter_flow/flutter_flow_widgets.dart';
import '/flutter_flow/form_field_controller.dart';
import 'diet_list_widget.dart' show DietListWidget;
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:provider/provider.dart';

class DietListModel extends FlutterFlowModel<DietListWidget> {
  ///  State fields for stateful widgets in this page.

  FocusNode? searchRiceFocusNode;
  TextEditingController? searchRiceTextController;
  String? searchRiceValue;
  String? Function(BuildContext, String?)? searchRiceTextControllerValidator;

  FocusNode? searchSoupFocusNode;
  TextEditingController? searchSoupTextController;
  String? searchSoupValue;
  String? Function(BuildContext, String?)? searchSoupTextControllerValidator;

  FocusNode? searchSideDishFocusNode;
  TextEditingController? searchSideDishTextController;
  String? searchSideDishValue;
  String? Function(BuildContext, String?)?
      searchSideDishTextControllerValidator;

  // State field(s) for DropDown widget.
  String? dropDownValue1;
  FormFieldController<String>? dropDownValueController1;
  // State field(s) for DropDown widget.
  String? dropDownValue2;
  FormFieldController<String>? dropDownValueController2;

  // State field(s) for PaginatedDataTable widget.
  final paginatedDataTableController =
      FlutterFlowDataTableController<dynamic>();
  // Stores action output result for [Backend Call - API (GetDietInfo)] action in Button widget.
  ApiCallResponse? apiResultodd;
  // Stores action output result for [Backend Call - API (SearchDietLists)] action in Button widget.
  ApiCallResponse? apiResultsort;

  ApiCallResponse? apiResultsearch;

  ApiCallResponse? apiResultInitList;

  @override
  void initState(BuildContext context) {}

  @override
  void dispose() {
    searchRiceFocusNode?.dispose();
    searchRiceTextController?.dispose();

    searchSoupFocusNode?.dispose();
    searchSoupTextController?.dispose();

    searchSideDishFocusNode?.dispose();
    searchSideDishTextController?.dispose();

    paginatedDataTableController.dispose();
  }
}
