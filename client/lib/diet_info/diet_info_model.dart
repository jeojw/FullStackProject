import '/flutter_flow/flutter_flow_data_table.dart';
import '/flutter_flow/flutter_flow_theme.dart';
import '/flutter_flow/flutter_flow_util.dart';
import '/flutter_flow/flutter_flow_widgets.dart';
import 'diet_info_widget.dart' show DietInfoWidget;
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:provider/provider.dart';

class DietInfoModel extends FlutterFlowModel<DietInfoWidget> {
  ///  State fields for stateful widgets in this page.

  // State field(s) for NutrientTable widget.
  final nutrientTableController = FlutterFlowDataTableController<dynamic>();

  @override
  void initState(BuildContext context) {}

  @override
  void dispose() {
    nutrientTableController.dispose();
  }
}
